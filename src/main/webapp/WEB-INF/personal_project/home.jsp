<%@include file="/WEB-INF/personal_project/top.jsp"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${appURL}/css/loading.css">
</head>
<body>
<main class="container mb-4">
    <h1>Welcome to the DragonBall Z Game</h1>
    <div id="carouselExampleCaptions" class="carousel carousel-dark slide">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${appURL}/images/personal_project/goku.jpg" class="d-block w-100 h-100" alt="Goku">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Characters</h5>
                    <p>DragonBall Z Characters</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="${appURL}/images/personal_project/martial_arts_tournament.jpg" class="d-block w-100" alt="Martial Arts Tournament">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Maps</h5>
                    <p>DragonBall Z Maps</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="${appURL}/images/personal_project/sensu_bean.jpg" class="d-block w-100" alt="Sensu Bean">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Items</h5>
                    <p>DragonBall Z Items</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</main>

<%@include file="/WEB-INF/personal_project/bottom.jsp"%>
