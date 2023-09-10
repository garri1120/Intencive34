# Intencive34

## Task1

Бизнес задача — получить расчетную цену услуг\товаров и т.д. из сформированного сущностями предметной области списка.


Предметная область: Продажа автозапчастей бу\новых.

Финально, создать класс который бы в качестве поля содержал в себе все создаваемые заказы\услуги в виде списка,
и в нем 2 метода:
1) подсчет цены всех добавленых заказов\товаров\услуг
2) вывод заказов в отсортированный список по фамилии User, в алфавитном порядке.

## Task2

1) Реализовать свой производный от Exception класс который должен содержать код ошибки и его текстовое описание.
   Добавить обработку ошибок в созданный ранее проект.
   Написать тесты на Exception.

2) Дополнительно в тестах отдельно создать экземпляры ArrayList, HashMap, TreeSet со всеми возможными конструкторами.
   Вызвать основные методы коллекций, и создать на них тесты.
   у Collections вызвать его методы для созданного экземпляра ArrayList выполнить на них тесты.

   В данной ветке сделать не менее 2 коммитов и сделать сквош коммитов.
   Создать ветку feature\task2_ и перенести через CherryPick из feature\task21_ коммит.


## Task4

1) Создать скрипты создающие 2 таблицы USER, ORDER, где
   USER имеет ид, ФИО, телефон, емейл, заказ(order_id)
   ORDER имеет явно ID и какие-то аттрибуты.
   Скрипты положить в resources/sql вашего проекта. Создать \ наполнить БД через скрипты.

2) Создать сервис, который может производить подключение через драйвер JDBC
   к выбранной вами БД.

3) Данные подключения пароль\логин и т.д. храним в resources/application.properties,
   читаем через ResourceBundle. Данные хранить в закрытом виде.

4) Используем PreparedStatement /  Statement / ResultSet
 
5) Создать метод, который бы получал данные из объединения таблиц.

6) Обработка исключений/тесты