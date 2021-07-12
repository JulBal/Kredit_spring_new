Тестовое задание Junior Java Developer
Результатом выполнения данного задания должно быть работающее веб-приложение,
удовлетворяющее требованиям ниже и качественных исходный код.
Задание должно быть выполнено полностью самостоятельно, не копируйте и не используйте
код других соискателей. Постарайтесь создать грамотную композицию классов и форматировать
код в соответствии со стандартами Java.
Описание задачи
Разработать веб-приложение, включая следующие сущности и атрибуты:

• Клиент
o ФИО
o Номер телефона
o Электронная почта
o Номер паспорта
• Банк
o Список кредитов
o Список клиентов
• Кредит
o Лимит по кредиту
o Процентная ставка
• Кредитное предложение
o Клиент
o Кредит
o Сумма кредита
o График платежей
▪ Дата платежа
▪ Сумма платежа
▪ Сумма гашения тела кредита
▪ Сумма гашения процентов
Приложение должно реализовывать следующие функции:
• Добавление, редактирование и удаление сущностей.
• Процесс оформления кредита на клиента с созданием графика платежей и расчетом
необходимых сумм:
o Автоматический расчет итоговой суммы процентов по кредиту;
o Автоматический расчет суммы ежемесячного платежа с учетом процентной
ставки.
Интерфейс пользователя
Приложение должно содержать:
• Экраны для добавления/редактирования/удаления сущностей;
• Экран для формирования кредитного предложения и просмотра графика платежей,
итоговой суммы по кредиту.
Интерфейс пользователя должен быть простым, логичным и удобным. Обращайте внимание
на то, как и какие элементы будет правильно расположить на экранах, как с ними будет
взаимодействовать пользователь.
Требования к реализации

● Java 8 или 11;
● Доступ к данным через JDBC или JPA;

● Код доступа к данным должен быть изолирован в классах DAO;
● Каждая таблица должна иметь первичный ключ типа UUID;
● Готовое приложение должно содержать:
o Каталог с исходными текстами и проектным файлом Maven (pom.xml)
o SQL-скрипт создания таблиц в базе данных в виде отдельного файла проекта.
Примечание: требуется SQL скрипт создания всех необходимых объектов в БД,
написанный вручную;
● Файлы базы данных HSQLDB;
● Приложение должно подключаться к БД без необходимости старта отдельного
сервера;
● Для запуска приложения должно быть достаточно собрать его при помощи Maven

Примечание:
• Использование JPA необязательно, при этом использование ORM и Spring/Spring Boot
будет плюсом;
• Реализация UI-приложения на Ваш выбор: Swing, JavaFX, Vaadin, GWT, Servlets/JSP и т.д.
Проект с исходным кодом должен быть размещен на Github и содержать наполненную БД,
на которой производилось тестирование. После выполнения задания ответным письмом
присылайте ссылку на репозиторий Github.
