INSERT INTO public.editor (ID_EDITOR, NAME)
VALUES (1, 'Juan');
INSERT INTO public.editor (ID_EDITOR, NAME)
VALUES (2, 'Pedro');
INSERT INTO public.editor (ID_EDITOR, NAME)
VALUES (3, 'Pablo');
INSERT INTO public.editor (ID_EDITOR, NAME)
VALUES (4, 'Judas');
INSERT INTO public.editor (ID_EDITOR, NAME)
VALUES (5, 'Andres');

INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'Java', 'test.com/java');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'Python', 'test.com/python');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'C#', 'test.com/CSHARP');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'JavaScript', 'test.com/javascript');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'Kotlin', 'test.com/kotlin');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'TypeScript', 'test.com/typescript');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'Go', 'test.com/go');
INSERT INTO public.article (ID_ARTICLE, EDITOR_ID_EDITOR, TITLE, URL)
VALUES (RANDOM_UUID(), 1, 'Rust', 'test.com/Rust');