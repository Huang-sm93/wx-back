let currentPage = 1;
let totalPages = 0;
let searchStartTime = 0;
let columnames = ['es-cenamekwd', 'es-word', 'distance', 'sight2parentdistance', 'es-gsprefecturelevelcityid', 'es-multikeyword', 'roughtextualrecall', 'es-address', 'debug-use-stage', 'es-gsdistrictpathids', 'es-roughscore', 'es-track-score', 'es-sort-scores']
let totalCount = 0
let extendInfos = ''
let cm = ''
//转换html实体
const parser = new DOMParser();

window.onload = function () {
    fetch('http://localhost:8080/user/getpage', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify({
            pageIndex: 0,
            pageSize: 10
        }),
    })
        .then(response => response.json())
        .then(data => {
            responseBody = data;
            findResult = displayResults(responseBody);
            displaySearchTime();
            updatePagination(responseBody.pageCount || 0);
            if (nextFunction != undefined) {
                nextFunction(findResult)
            }
        })
        .catch(error => console.error('Error:', error));
}

function displayResults(data) {
    const resultsBody = document.getElementById('results-body');
    resultsBody.innerHTML = ''; // Clear previous results
    find = false
    let index = (currentPage - 1) * 10;
    if (data.hasOwnProperty('sights') && data.sights !== null && data.sights !== undefined) {
        data.sights.forEach(result => {
            index++;

            const row = resultsBody.insertRow();
            const cell1 = row.insertCell();
            cell1.textContent = index;

            const cell2 = row.insertCell();
            cell2.textContent = result['poiId'];
            if (findPoiid != undefined && String(result['poiId']) === String(findPoiid)) {
                find = true
                cell2.style.backgroundColor = "yellow";
            }

            const fieldMap = new Map();
            if (result.hasOwnProperty('fieldItemList') && result.fieldItemList !== null && result.fieldItemList !== undefined) {
                Object.values(result.fieldItemList).forEach(field => {
                    fieldMap.set(field.key.toLowerCase(), field.value)
                });
            }

            for (i = 0; i < columnames.length; i++) {
                const fieldName = columnames[i].toLowerCase();
                const fieldValue = fieldMap.get(fieldName);
                const cell = row.insertCell();
                const decodedValue = parser.parseFromString(fieldValue, 'text/html').body.textContent;
                const regex = new RegExp(k, 'gi');
                const replacedValue = decodedValue.replace(regex, (match) => {
                    return `<span style="color: red;">${match}</span>`;
                });
                cell.innerHTML = replacedValue;
            }
        });
    }

    totalCount = data.rowCount || 0;
    extendInfos = ''
    if (data.hasOwnProperty('extendInfos') && data.extendInfos !== null && data.extendInfos !== undefined) {
        extendInfos = extendParse(data.extendInfos)
    }
    cm = 'https://bat.fx.ctripcorp.com/logview/' + extractCmValue(data.debugInfo)

    return find
}

function extractCmValue(str) {
    if (str === undefined || str === '') {
        return null;
    }
    const regex = /cm:(.*?);/;
    const match = str.match(regex);

    if (match) {
        return match[1];
    } else {
        return null;
    }
}

function extendParse(extendInfos) {
    const fieldMap = new Map();
    Object.values(extendInfos).forEach(extend => {
        fieldMap.set(extend.type.toLowerCase(), extend)
    });

    let content = ''

    if (fieldMap.has('debug-stage')) {
        const debug_stage = fieldMap.get('debug-stage').value
        if (debug_stage !== null && debug_stage !== undefined) {
            content += '[最终阶段：' + debug_stage + ']'
        }
    }

    if (fieldMap.has('samenamegsiddefault')) {
        const samenamegsiddefault = fieldMap.get('samenamegsiddefault').value
        if (samenamegsiddefault !== null && samenamegsiddefault !== undefined && !isNaN(parseInt(samenamegsiddefault)) && parseInt(samenamegsiddefault) > 0) {
            content += '[默认同名目的地id：' + samenamegsiddefault + ']'
        }
    }

    if (fieldMap.has('debug-nlpnoresultusedefault')) {
        const debug_nlpnoresultusedefault = fieldMap.get('debug-nlpnoresultusedefault').value
        if (debug_nlpnoresultusedefault !== null && debug_nlpnoresultusedefault !== undefined && debug_nlpnoresultusedefault === 'true') {
            content += '[nlp没有结果]'
        }
    }

    return content
}

function displaySearchTime() {
    const searchTime = document.getElementById('search-time');
    const elapsedTime = performance.now() - searchStartTime;
    searchTime.innerHTML = `本次请求总结果数：${totalCount}, 耗时 ${elapsedTime.toFixed(2)} ms，bat链接：<a href="${cm}" target="_blank">${cm}</a>, 扩展信息：` + extendInfos;
}

function updatePagination(pageCount) {
    totalPages = pageCount;
    const pageInfo = document.getElementById('page-info');
    pageInfo.textContent = `Page ${currentPage} of ${totalPages}`;
}

function previousPage() {
    if (currentPage > 1) {
        currentPage--;
        search();
    }
}

function previous10Page() {
    if (currentPage > 10) {
        currentPage = currentPage - 10;
        search();
    } else {
        previousPage();
    }
}

function nextPage() {
    if (currentPage < totalPages) {
        currentPage++;
        search();
    }
}

function next10Page() {
    if (currentPage + 10 < totalPages) {
        currentPage = currentPage + 10;
        search();
    } else {
        nextPage();
    }
}

function findPoiSearch() {
    findresultspan.textContent = ''
    findPoiid = document.getElementById('findPoiid').value;
    if (findPoiid == undefined || findPoiid === '') {
        alert('need poiid');
        return
    }
    currentPage = 0
    loopSearch(findPoiid)
}

function loopSearch(findPoiid) {
    search(0, findPoiid, function (findResult) {
        if (findResult) {
            alertWithRemove('find ' + findPoiid);
            return;
        }
        currentPage++;
        if (currentPage != 1 && currentPage > totalPages) {
            alertWithRemove('not find ' + findPoiid);
            return;
        }
        loopSearch(findPoiid)
    })
}

function alertWithRemove(content) {
    findresultspan.textContent = content
}