<jsp:include page="include/header.jsp" />
<link rel="stylesheet" href="/pub/css/index.css" />

  <!-- Hero Image -->
    <section>
      <div class="hero-image">
        <div class="hero-text">
          <h1 style="font-size: 50px">Betty's Boutique</h1>
          <p>Begin Browsing</p>
        </div>
      </div>
    </section>

    <!-- Content Main -->
    <section>
      <div class="container-fluid">
        <div class="row justify-content-center p-3">
          <div class="col-md-3 col-sm-12">
            <img src="../../../pub/images/shoes1.jpg" alt="" />
          </div>
          <div class="col-md-3 col-sm-12">
            <img src="../../../pub/images/shoes2.jpg" alt="" />
          </div>
          <div class="col-md-3 col-sm-12">
            <img src="../../../pub/images/shoes3.jpg" alt="" />
          </div>
          <div
            class="col-md-3 col-sm-12 description"
            style="border: 2px solid #f1bb7f"
          >
            <h3 class="">Shoes</h3>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris
              cursus vestibulum mollis. Donec sit amet augue eget mauris
              tristique tincidunt eget mollis tortor. Sed ullamcorper.
            </p>
            <input
              type="button"
              class="button"
              value="Browse"
              onclick="location.href= 'apparel.html'"
            />
          </div>
        </div>
        <hr style="border-top: 1px solid #f45491" />

        <div class="row justify-content-center p-3">
          <div
            class="col-md-3 col-sm-12 description"
            style="border: 2px solid #69747b"
          >
            <h3 class="">Dresses</h3>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin
              cursus dapibus velit, quis facilisis diam ultrices ac. Suspendisse
              potenti. Nam finibus nulla non nisi gravida hendrerit. Morbi ante
              nisi, porta ultricies rhoncus a, dignissim nec.
            </p>
            <input
              type="button"
              class="button"
              value="Browse"
              onclick="location.href= 'apparel.html'"
            />
          </div>
          <div class="col-md-3 col-sm-12">
            <img src="../../../pub/images/dress1.jpg" alt="" />
          </div>
          <div class="col-md-3 col-sm-12">
            <img src="../../../pub/images/dress2.jpg" alt="" />
          </div>
          <div class="col-md-3 col-sm-12">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="../../../pub/images/dress_front.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="../../../pub/images/dress_side.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="../../../pub/images/dress_back.jpg" class="d-block w-100" alt="...">
                </div>
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
          <hr style="border-top: 1px solid #121212" />

          <div class="row justify-content-center p-3">
            <div class="col-md-3 col-sm-12">
              <img src="../../../pub/images/sweater1.jpg" alt="" />
            </div>
            <div class="col-md-3 col-sm-12">
              <img src="../../../pub/images/sweater2.jpg" alt="" />
            </div>
            <div class="col-md-3 col-sm-12">
              <img src="../../../pub/images/sweater3.jpg" alt="" />
            </div>
            <div
              class="col-md-3 col-sm-12 description"
              style="border: 2px solid #8ddcd2"
            >
              <h3 class="">Sweaters</h3>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                Vestibulum finibus sapien et nunc accumsan condimentum. Ut
                pellentesque vehicula lectus, eget mollis est feugiat quis.
                Mauris gravida.
              </p>
              <input
                type="button"
                class="button"
                value="Browse"
                onclick="location.href= 'apparel.html'"
              />
            </div>
          </div>
        </div>
      </div>
    </section>

<jsp:include page="include/footer.jsp" />
