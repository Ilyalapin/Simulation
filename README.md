Проект «Симуляция».

Проект написан в обучающих целях. Приоритеты - чистый ООП код, проектирование, знакомство с алгоритмами поиска. Проект предстваляет симуляцию 2D мира (40x10), населённого травоядными (Herbivore) и хищниками (Predator) (овцами 🐑 и волками 🐺 соответственно), ресурсами для травоядных (травой 🍀), статичными объектами (камнями 🏔️ и деревьями 🌳), играющими роль препятствий. Количество каждого объекта на поле строго определено, но их расположение случайно. Поиск ближайшего ресурса реализован алгоритмом поиска в ширину (BFS).

Сгенерированная карта

🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 
🍀 🐺 🔸 🍀 🔸 🍀 🍀 🔸 🍀 🍀 🐺 🔸 🐺 🍀 🔸 🐺 🐺 🏔️ 🔸 🍀 🐑 🔸 🍀 🔸 🔸 🔸 🍀 🔸 🐺 🐑 🔸 🐺 🍀 🔸 
🔸 🐺 🐑 🔸 🍀 🔸 🔸 🔸 🌳 🐑 🌳 🐺 🐑 🔸 🔸 🔸 🍀 🍀 🍀 🍀 🐑 🍀 🍀 🍀 🔸 🔸 🔸 🐑 🏔️ 🐺 🐑 🔸 🍀 🐺  
🐺 🍀 🐺 🔸 🍀 🔸 🌳 🔸 🏔️ 🔸 🍀 🍀 🔸 🐺 🔸 🔸 🔸 🔸 🔸 🐺 🍀 🔸 🏔️ 🍀 🍀 🔸 🍀 🔸 🌳 🐺 🐺 🔸 🍀 🍀  
🔸 🍀 🔸 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🔸 🐺 🐺 🍀 🐺 🍀 🐺 🐺 🍀 🐺 🔸 🐑 🏔️ 🍀 🌳 🔸 🍀 🔸 🍀 🔸 🍀 🔸 🍀 🌳 
🐺 🔸 🍀 🔸 🍀 🔸 🍀 🔸 🏔️ 🐺 🏔️ 🌳 🔸 🔸 🌳 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🔸 🐺 🍀 🐑 🍀 🐑 🔸 🔸 🐑 🍀 🔸 🔸 
🔸 🍀 🔸 🔸 🍀 🔸 🐑 🔸 🍀 🔸 🍀 🔸 🔸 🔸 🍀 🐑 🐺 🍀 🌳 🍀 🐑 🏔️ 🔸 🔸 🔸 🐺 🌳 🐺 🏔️ 🏔️ 🐺 🍀 🔸 🐑 
🍀 🌳 🏔️ 🔸 🔸 🍀 🐑 🔸 🍀 🐑 🏔️ 🍀 🌳 🔸 🐺 🔸 🍀 🐑 🍀 🐺 🔸 🍀 🏔️ 🏔️ 🐺 🐺 🔸 🐺 🍀 🏔️ 🔸 🍀 🍀 🍀 
🍀 🍀 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🏔️ 🐺 🍀 🌳 🔸 🐑 🍀 🔸 🍀 🐑 🍀 🔸 🍀 🔸 🔸 🐑 🔸 🐺 🐺 🔸 🌳 🏔️ 🍀 🐺 🔸 
🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 

Описание процесса: 

-Передвижение существ осуществяется по 4 направлениям: вверх, вниз, вправо, влево.

-Каждое существо имеет скорость. Скорость представляет из себя количество клеток, которое сущетсво может пройти за один ход.

-Каждое существо стремится найти ближайшую для себя жертву (victim). Для хищников ресурс - травоядные, для травоядных - трава. 

-На передвижение каждое существо тратит здоровье (healthPoints), а поглощение жертвы его восполняет (но не может превысить его максимальное значение).

-Травоядные поглощают ресурс моментально. Хищники же делают укус, который отнимает здоровье у травоядного на величину, равную силе атаки хищника (ATACK_POWER). Если эта величина оказывается больше, чем текущее здоровье травоядного - оно умирает.

-Чтобы дать травоядным больше шансов на выживание, их скорость передвижения в 2 раза больше, чем у хищников.

-Так как травоядные быстрее поглощают своих жертв, в симуляции реализован метод постоянно пополнения травы на карте.

-Игра завершается при гибели всех хищников или травоядных.

Для детального изучения карты, пользователю предоставлены функции остановки и возобновления симуляции, а также выполнение симуляции пошагово со счетчиком выполненных итераций.

🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 
🔸 🍀 🔸 🐑 🐺 🍀 🔸 🍀 🔸 🔸 🍀 🍀 🐺 🔸 🔸 🔸 🌳 🔸 🍀 🍀 🔸 🔸 🔸 🔸 🐺 🔸 🔸 🔸 🔸 🍀 🔸 🔸 🔸 🏔️ 
🐺 🍀 🐺 🔸 🍀 🔸 🌳 🔸 🏔️ 🔸 🍀 🍀 🔸 🐺 🔸 🔸 🔸 🔸 🔸 🐺 🍀 🔸 🏔️ 🍀 🍀 🔸 🍀 🔸 🌳 🐺 🐺 🔸 🍀 🍀 
🐑 🔸 🌳 🔸 🍀 🔸 🍀 🔸 🔸 🏔️ 🔸 🐑 🏔️ 🔸 🔸 🐺 🍀 🔸 🔸 🔸 🔸 🔸 🔸 🔸 🍀 🐑 🌳 🍀 🔸 🌳 🔸 🏔️ 🍀 🍀 
🔸 🍀 🔸 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🔸 🐺 🐺 🍀 🐺 🍀 🐺 🐺 🍀 🐺 🔸 🐑 🏔️ 🍀 🌳 🔸 🍀 🔸 🍀 🔸 🍀 🔸 🍀 🌳 
🐺 🔸 🍀 🔸 🍀 🔸 🍀 🔸 🏔️ 🐺 🏔️ 🌳 🔸 🔸 🌳 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🔸 🐺 🍀 🐑 🍀 🐑 🔸 🔸 🐑 🍀 🔸 🔸 
🔸 🍀 🔸 🔸 🍀 🔸 🐑 🔸 🍀 🔸 🍀 🔸 🔸 🔸 🍀 🐑 🐺 🍀 🌳 🍀 🐑 🏔️ 🔸 🔸 🔸 🐺 🌳 🐺 🏔️ 🏔️ 🐺 🍀 🔸 🐑 
🍀 🌳 🏔️ 🔸 🔸 🍀 🐑 🔸 🍀 🐑 🏔️ 🍀 🌳 🔸 🐺 🔸 🍀 🐑 🍀 🐺 🔸 🍀 🏔️ 🏔️ 🐺 🐺 🔸 🐺 🍀 🏔️ 🔸 🍀 🍀 🍀 
🍀 🍀 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🏔️ 🐺 🍀 🌳 🔸 🐑 🍀 🔸 🍀 🐑 🍀 🔸 🍀 🔸 🔸 🐑 🔸 🐺 🐺 🔸 🌳 🏔️ 🍀 🐺 🔸 
🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 

Выберите действие: 1 - Запуск симуляции. 2 - Сделать одну итерацию. 3 - Выйти

4 - Пауза симуляции

🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧
🍀 🔸 🔸 🔸 🐺 🔸 🐑 🍀 🍀 🐺 🍀 🐺 🔸 🔸 🔸 🔸 🍀 🏔️ 🔸 🔸 🔸 🔸 🐑 🔸 🔸 🔸 🐑 🔸 🔸 🐺 🔸 🔸 🔸 🔸 
🔸 🔸 🐺 🔸 🔸 🐺 🔸 🔸 🌳 🔸 🌳 🔸 🔸 🍀 🐺 🔸 🔸 🐺 🔸 🔸 🍀 🔸 🔸 🍀 🍀 🐺 🔸 🐺 🏔️ 🔸 🔸 🐺 🐺 🐺 
🔸 🐺 🔸 🔸 🔸 🔸 🍀 🍀 🔸 🔸 🐺 🔸 🔸 🔸 🔸 🔸 🌳 🍀 🐑 🐺 🔸 🔸 🍀 🔸 🔸 🐑 🔸 🔸 🔸 🐺 🔸 🔸 🔸 🏔️  
🔸 🐺 🌳 🔸 🍀 🔸 🔸 🔸 🐑 🏔️ 🔸 🐺 🏔️ 🔸 🐺 🔸 🐺 🔸 🔸 🐺 🔸 🔸 🍀 🔸 🔸 🔸 🌳 🔸 🔸 🌳 🔸 🏔️ 🍀 🍀 
🔸 🍀 🔸 🔸 🍀 🔸 🔸 🔸 🍀 🔸 🐑 🐺 🔸 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🔸 🔸 🏔️ 🐺 🌳 🐺 🔸 🔸 🍀 🔸 🐺 🔸 🍀 🌳 
🔸 🔸 🍀 🔸 🐑 🔸 🔸 🔸 🏔️ 🔸 🏔️ 🌳 🔸 🔸 🌳 🔸 🔸 🔸 🔸 🔸 🔸 🔸 🔸 🔸 🍀 🔸 🐑 🐺 🔸 🔸 🔸 🍀 🔸 🔸 
🔸 🍀 🔸 🔸 🔸 🔸 🔸 🔸 🔸 🔸 🍀 🐺 🔸 🔸 🔸 🐺 🐺 🔸 🌳 🐺 🐑 🏔️ 🔸 🔸 🔸 🐺 🌳 🐺 🏔️ 🏔️ 🔸 🍀 🔸 🐺 
🍀 🌳 🏔️ 🔸 🔸 🔸 🔸 🍀 🐑 🐺 🏔️ 🔸 🌳 🔸 🔸 🔸 🔸 🐺 🔸 🔸 🔸 🐑 🏔️ 🏔️ 🍀 🔸 🐺 🔸 🍀 🏔️ 🔸 🍀 🔸 🍀 
🍀 🍀 🔸 🔸 🔸 🍀 🔸 🍀 🔸 🏔️ 🍀 🔸 🌳 🔸 🔸 🔸 🔸 🔸 🔸 🐑 🐑 🔸 🔸 🐺 🔸 🔸 🐺 🔸 🔸 🌳 🏔️ 🍀 🍀 🔸 
🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 🚧 

Количество итераций: 3