# TaskManager

# Описание 
Приложение для организации совместной работы над проектами. Приложение позволяет выполнять CRUD-операции над проектами и задачами.

Для начала работы с проектами необходимо зарегистрироваться. При регистрации доступны две роли для пользователей: "user" и "admin".

Только "admin" может создавать проекты, после чего он может передавать ссылку для совместной работы над проекту любому пользователю. При создании проекта для роли отвественного "admin" может выбрать любого пользователя, работающего в одном отделе с ним. Любой пользователь, учавтсвующий в проекте, может создавать и удалять задачи.

Приложение состоит из трех слоев : 
  1. Database
  2. Service
  3. Web view
     
Каждый слой храниться в отдельном maven проекте, а все они, в свою очередь, лежат в родительском maven проекте.

# Стек
+ Java 11 (Core, Collections, Optional, Stream) 
+ PostgreSQL 42.6.0
+ Servlets  
+ JDBC
+ Maven 3.9.4
+ Apache Tomcat 10.1.13
+ JSP, JSTL
+ CSS

# Схема базы данных
![image](https://github.com/DanilKucheruk/TaskManager/assets/147261620/90f907a4-54ea-40e6-8902-724776f14259)
