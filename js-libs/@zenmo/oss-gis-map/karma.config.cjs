module.exports = function(config) {
    config.set({
        frameworks: ['jasmine'],
        files: [
            { pattern: 'test/map.test.js', watched: false },
        ],
        preprocessors: {
            'test/map.test.js': ['webpack'],
        },
        webpack: {
            mode: 'development',
            module: {
                rules: [
                    {
                        test: /\.css$/,
                        use: ['style-loader', 'css-loader'],
                    },
                ],
            },
            experiments: {
                topLevelAwait: true,
            },
        },
        browsers: ['Chromium'],
        singleRun: true,
        client: {
            jasmine: {
                timeoutInterval: 30000,
            },
        },
    });
};
