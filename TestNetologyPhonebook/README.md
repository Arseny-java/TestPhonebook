# TestNetologyPhonebook
Тестовое задание для тренеров Нетологии "Телефонный справочник"

Об авторе:

* Как вас зовут? - Сазонов Арсений;
* Кем вы сейчас работаете? - QA Automation Engineer на проекте ВТБ-банка;
* За какие процессы / области отвечаете на работе? - автоматизация тест-кейсов, участие в разработке структуры фреймворка;
* Каким стеком технологий вы владеете лучше всего? - Java Core, Selenium, Selenide, Allure, TeamCity, BitBucket, Jenkins; 
* С какими инструментами работаете? - Intellij Idea, VSCode;
* Домашние работы каких тем из курса Java Developer вы бы хотели проверять? - готов на всё);
* Хотели бы не только участвовать в проверке домашних работ, но и вести лекции? - в будущем имею такую цель;
* Есть ли у вас проекты на github (если есть приложите пожалуйста ссылку) - на github только учебные проекты, интереса особо не представляют);

О проекте: 

  Консольное приложение "Телефонный справочник":
  
  1. Запуск приложения производится при запуске метода main класса PhonebookRunner;
  2. В качестве БД используется файл с расширением .json. При запуске приложения производится проверка на существование директории resources и существование файла.
  При отсустсвии директории файла, он создается. Выбор формата файла phonebook.json обусловлен удобством парсинга библиотекой Jackson;
  3. Данные в файл phonebook.json сохраняются в виде HashMap<> после завершения работы с программой через ввод команды "0" с клавиатуры пользователя,
  где ключом является телефонный номер, а значением-объект Contact. 
  Выбор коллекции Map(а Map является коллекцией по своей сути, но не расширяет при этом интерфейс Collections), обусловлен возможностью хранить
  уникальные ключи(номер телефона) и в случае сохранения контакта перезаписать контакт на новый, так как имя, фамилия и группа может совпадать, 
  но номер является уникальным идентификатором котакта;
  
  Принципы ООП:
  
  1. Инкапсуляция: все поля класса Contact имеют модификатор доступа private, тем самым обеспечивая объединение кода в одном классе
  и сокрытие деталей реализации от пользователя. Доступ предоставляется через геттеры и сеттеры;
  2. Абстракция: объект Contact представлен минимальным набором полей и методов и при этом с достаточной точностью для решаемой задачи;
  3. Полиморфизм: например при создании обекта интерфейса Map<> - "Map<String, Contact> phonebook = new HashMap<>()";
  4. Наследование: в данном проекте в явном виде не использовалось. Хотя тот же объект Contact является наследником класса Object и имеет методы hashCode(), equals() и т.д.;
