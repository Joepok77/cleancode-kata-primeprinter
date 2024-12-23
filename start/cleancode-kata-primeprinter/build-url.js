function buildUrl(url, options) {
    var queryString = [];
    var key;
    var builtUrl;

    builtUrl = determineBaseUrl(url);

    if (options) {
           if (options.path) {
               builtUrl = appendPath(builtUrl, options.path);
           }
        if (options.queryParams) {
            for (key in options.queryParams) {
                if (options.queryParams.hasOwnProperty(key)) {
                    queryString.push(key + '=' + options.queryParams[key]);
                }
            }
            builtUrl = builtUrl + '?' + queryString.join('&');
        }

        builtUrl = options.hash ? builtUrl + '#' + options.hash : builtUrl;
    }

    return builtUrl;
}

function determineBaseUrl(url) {
    if (url === null || typeof url === 'object') {
        return '';
    }
    return url;
}