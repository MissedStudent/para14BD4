-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 15 2024 г., 10:31
-- Версия сервера: 8.0.24
-- Версия PHP: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `onlinecourses`
--

-- --------------------------------------------------------

--
-- Структура таблицы `certificats`
--

CREATE TABLE `certificats` (
  `id_certificat` int NOT NULL,
  `certificat_name` text NOT NULL,
  `teacher_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `certificats`
--

INSERT INTO `certificats` (`id_certificat`, `certificat_name`, `teacher_id`) VALUES
(1, 'участие в межгородском турнире', 1),
(2, 'участие в региональном турнире', 2),
(3, 'сертиф', 1),
(4, 'сертификат крутого преподавателя', 2),
(5, 'Лучший президент всех времен и народов', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `courses`
--

CREATE TABLE `courses` (
  `id_course` int NOT NULL,
  `course_name` text NOT NULL,
  `course_hours` int NOT NULL,
  `teacher_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `courses`
--

INSERT INTO `courses` (`id_course`, `course_name`, `course_hours`, `teacher_id`) VALUES
(1, 'Системное программирование', 102, 1),
(2, 'Английский язык', 94, 2),
(3, 'Политика', 56, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `lessons`
--

CREATE TABLE `lessons` (
  `id_lesson` int NOT NULL,
  `lesson_theme` text NOT NULL,
  `course_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `lessons`
--

INSERT INTO `lessons` (`id_lesson`, `lesson_theme`, `course_id`) VALUES
(1, 'Вывод строки', 1),
(2, 'Создание калькулятора', 1),
(3, 'Неправильные глаголы', 2),
(4, 'Разбор параграфа', 2),
(5, 'Встреча иностранных послов', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `records`
--

CREATE TABLE `records` (
  `id_record` int NOT NULL,
  `student_surname` text NOT NULL,
  `course_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `records`
--

INSERT INTO `records` (`id_record`, `student_surname`, `course_id`) VALUES
(1, 'Кузовлев', 1),
(2, 'Кузнецов', 2),
(3, 'Миниполитик', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `teachers`
--

CREATE TABLE `teachers` (
  `id_teacher` int NOT NULL,
  `teacher_surname` text NOT NULL,
  `teacher_name` text NOT NULL,
  `teacher_lastname` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `teachers`
--

INSERT INTO `teachers` (`id_teacher`, `teacher_surname`, `teacher_name`, `teacher_lastname`) VALUES
(1, 'Иванов', 'Иван', 'Иванович'),
(2, 'Александров', 'Александр', 'Александрович'),
(3, 'Путин', 'Владимир', 'Владимирович');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `certificats`
--
ALTER TABLE `certificats`
  ADD PRIMARY KEY (`id_certificat`);

--
-- Индексы таблицы `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id_course`);

--
-- Индексы таблицы `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`id_lesson`);

--
-- Индексы таблицы `records`
--
ALTER TABLE `records`
  ADD PRIMARY KEY (`id_record`);

--
-- Индексы таблицы `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id_teacher`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `certificats`
--
ALTER TABLE `certificats`
  MODIFY `id_certificat` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `courses`
--
ALTER TABLE `courses`
  MODIFY `id_course` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `lessons`
--
ALTER TABLE `lessons`
  MODIFY `id_lesson` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `records`
--
ALTER TABLE `records`
  MODIFY `id_record` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id_teacher` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
