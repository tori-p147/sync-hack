Платформа для совершения операций на финансовом рынке


Как сбилдить и развернуть в докере:

    Проваливаемся в папку с проектом
    замускаем maven package (я запускаю справа в идее)
    Запускаем билд имиджа
    sudo docker build -t andrey1362010/sofkom .
    Логинимся в докер хабе (к моей учетке привязан andrey1362010/sofkom), если хотите свою, то надо изменить andrey1362010/sofkom все на свою репу
    sudo docker login
    Пушим
    docker push andrey1362010/sofkom:latest
    
    Заходим на сервак по ssh
    ssh root@89.108.103.86
    
    пулим
    docker pull postgres
    docker pull andrey1362010/sofkom:latest
    
    запускаем
    sudo docker run -itd -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgress -p 5432:5432 --name postgresql postgres
    sudo docker run -d --network="host" andrey1362010/sofkom
    IP: 89.108.103.86

### API documentation
[Swagger UI](http://localhost:8080/swagger-ui.html)
