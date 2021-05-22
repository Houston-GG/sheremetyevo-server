<h2>Серверная часть</h4>

<h4>Реализованная функциональность</h4>
<ul>
    <li>Авторизиация;</li>
    <li>Добавление задачи на уборку;</li>
    <li>Получение задач назначенных уборщику;</li>
    <li>Определение расстояния от точки уборки до ближайшего транспорта, с учетом их доступности и вида уборки участка (нужна ли машина с реагентом);</li>
</ul> 
<h4>Особенность проекта в следующем:</h4>
<ul>
 TODO
 </ul>
<h4>Основной стек технологий:</h4>
<ul>
    <li>JAVA</li>
    <li>Spring</li>
    <li>MySQL</li>
    <li>Docker, Kubernetes</li>
	<li>Git</li>
	<li>TeamCity</li>

 </ul>
<h4>Демо</h4>
<p>Демо сервиса доступно по адресу: https://sheremetyevo.visdom.tech/api-v1 </p>
<p>Реквизиты тестового пользователя: login: <b>admin</b>, пароль: <b>testpass</b></p>

УСТАНОВКА
------------
### Установка пакета name

Выполните
~~~
mvn clean install
~~~
### База данных

Необходимо создать пустую схему sheremetyevo в базе данных MySQL , при подключении к базе прописать в конфигурационный файл сервиса по адресу: src/main/resources/application.properties

РАЗРАБОТЧИКИ

<h4>Сибирный Никита backend https://t.me/Striker1337Q </h4>
<h4>Носкин Виктор backend https://t.me/vitek999 </h4>
<h4>Кулевич Андрей frontend https://t.me/Andrey_Kulevich </h4>
<h4>Зубков Александр тимлид / unity https://t.me/OrangAlex </h4>
<h4>Черкашин Дмитрий unity https://t.me/ByDiDinDiy </h4>


