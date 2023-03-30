<jsp:include page="include/header.jsp" />
<link rel="stylesheet" href="/pub/css/index.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
            <div
              id="carouselExampleIndicators"
              class="carousel slide"
              data-ride="carousel"
            >
              <ol class="carousel-indicators">
                <li
                  data-target="#carouselExampleIndicators"
                  data-slide-to="0"
                  class="active"
                ></li>
                <li
                  data-target="#carouselExampleIndicators"
                  data-slide-to="1"
                ></li>
                <li
                  data-target="#carouselExampleIndicators"
                  data-slide-to="2"
                ></li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img
                    class="d-block w-100"
                    src="../../../pub/images/dress_front.jpg"
                    alt="First slide"
                  />
                </div>
                <div class="carousel-item">
                  <img
                    class="d-block w-100"
                    src="../../../pub/images/dress_side.jpg"
                    alt="Second slide"
                  />
                </div>
                <div class="carousel-item">
                  <img
                    class="d-block w-100"
                    src="../../../pub/images/dress_back.jpg"
                    alt="Third slide"
                  />
                </div>
              </div>
              <a
                class="carousel-control-prev"
                href="#carouselExampleIndicators"
                role="button"
                data-slide="prev"
              >
                <span
                  class="carousel-control-prev-icon"
                  aria-hidden="true"
                ></span>
                <span class="sr-only">Previous</span>
              </a>
              <a
                class="carousel-control-next"
                href="#carouselExampleIndicators"
                role="button"
                data-slide="next"
              >
                <span
                  class="carousel-control-next-icon"
                  aria-hidden="true"
                ></span>
                <span class="sr-only">Next</span>
              </a>
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

    <!-- Content Extra -->
    <section>

    </section>

<jsp:include page="include/footer.jsp" />
