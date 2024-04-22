# T1 Homework 3

Реализована система мониторинга с использованием Spring Kafka.

Модель метрики:\
Сущность Metric с полями: applicationVersion (версия приложения), responseTime (время отклика).

Producer Service (metrics-producer, порт 8080):\
POST /metrics: отправка метрики в Kafka топик "metrics-topic" в формате JSON следующего формата:
```json
{
  "applicationVersion": "1.34.4",
  "responseTime": 342.4
}
```

Consumer Service (metrics-consumer, порт 8081):\
Прием метрики из Kafka топика "metrics-topic" и сохранение ее в базу.\
GET /metrics: получение списка всех метрик.\
GET /metrics/{id}: получение конкретной метрики по ее идентификатору.

Запуск через docker-compose up.