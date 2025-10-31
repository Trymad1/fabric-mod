# Тестовое задание Fabric mod
<img width="1919" height="1002" alt="Screenshot_6" src="https://github.com/user-attachments/assets/0e3dd8f6-9079-4fc6-8943-5538a15c261e" />

**GRADLE**: 8.14<br>
**MINECRAFT**: 1.21.8.<br>
**FACRIC LOADER**: 0.17.3.<br>
**FABRIC VERSION**: 0.136.0+1.21.8.<br>
**Маппинг**: Mojang.<br>


## Реализовано:
- Окно для ввода сообщений используя LibGUI. Окно выводится при заходе в мир, открыть его снова можно на клавишу M(английскую). Изменить назначение клавиши можно в настройках;
  - Файл описывающий интерфейс окна [TextFieldGuiDescription](src/client/java/com/trymad/screen/TextFieldGuiDescription.java);
- Передача сообщения на серверную часть, кодируя и декодурия его при помощи Protobuf;
  - Пакет передаваемый на сервер: [MessageC2SPayload](src/main/java/com/trymad/network/MessageC2SPayload.java);
  - Proto файл: [Message.proto](src/main/proto/Message.proto);
- Сохранение сообщений в базу данных используя Hibernate;
  - Xml конфигурация [hibernate.cfg.xml](src/main/resources/hibernate.cfg.xml);
  - Создание SessionFactory [HibernateUtil.java](src/main/java/com/trymad/util/HibernateUtil.java);
  - Сервис для сохранения Message в БД [MessageService.java](src/main/java/com/trymad/service/MessageService.java);
  - Класс для асинхронных запросов к БД [AsyncDatabase](src/main/java/com/trymad/util/AsyncDatabase.java);
  - Сущность таблицы в БД [MessageEntity](src/main/java/com/trymad/model/MessageEntity.java);
  - Обработчик входящего пакета с сервера [ServerModNetwork.java](src/main/java/com/trymad/network/ServerModNetwork.java).

## Запуск PostgreSQL для Minecraft в Docker

Можно использовать уже созданную базу, изменив данные авторизации в [hibernate.cfg.xml](src/main/resources/hibernate.cfg.xml). 
Для работы необходима только созданная БД с названием "minecraft", таблицу Hibernate создаст сам.
Или использовать готовые скрипты для запуска БД в Docker
# bash:
```bash
docker run -d \
  --name postgres_minecraft \
  -e POSTGRES_USER=root \
  -e POSTGRES_PASSWORD=password \
  -e POSTGRES_DB=minecraft \
  -p 5432:5432 \
  postgres:17
```
# powershell
```powershell
docker run -d `
  --name postgres_minecraft `
  -e POSTGRES_USER=root `
  -e POSTGRES_PASSWORD=password `
  -e POSTGRES_DB=minecraft `
  -p 5432:5432 `
  postgres:17

```
    
