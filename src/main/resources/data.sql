INSERT INTO `task_type` VALUES 
(1,'緊急','最優先で取り掛かるべきタスク'),
(2,'重要','期限に間に合わせるべきタスク'),
(3,'できれば','今後やってみたいアイデア');

INSERT INTO `task` VALUES 
(NULL,1,1,'JUnitを学習','テストの仕方を学習する','2020-07-07 15:00:00'),
(NULL,1,3,'サービスの自作','マイクロサービスを作ってみる','2020-09-13 17:00:00');

INSERT INTO `user` VALUES
(NULL, 'ユーザー1', 'user1@example.com', 'password1', 1, 'USER'),
(NULL, 'ユーザー2', 'user2@example.com', 'password2', 0, 'USER'),
(NULL, 'ユーザー3', 'user3@example.com', 'password3', 1, 'USER'),
(NULL, 'ユーザー4', 'user4@example.com', 'password4', 1, 'ADMIN');
