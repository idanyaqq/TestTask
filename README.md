# TestTask
Сервис приема сообщений по json-rpc на основе библиотеки jsonrpc4j.
Тестирование проводилось улититой Jmeter, но желаемых результатов по скорости отправки сообщений она не выдала.
Так же тестирование было проведено с помощью кастомной Apache Benchmark (https://github.com/andboson/ab-go) c небольшим (~5000) набором данных . На обработку 100к запросов уходило ~25-30c.
Hardware: Core i3-2120 3.30 GHz, RAM 16GB 1333 MHZ