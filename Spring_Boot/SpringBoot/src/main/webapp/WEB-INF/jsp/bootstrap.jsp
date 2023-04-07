<jsp:include page="include/header.jsp" />
<link rel="stylesheet" href="/pub/css/global.css"/>

  <style>
    a:visited{
      color:purple;
    }
    a:hover{
      color:orange;
    }
    h2:hover{
      background-color: bisque;
    }
    #firsth1{
      text-decoration: underline;
    }
    h3{
      display:none;
    }

    .absolute-example{
      width:200px;
      height:400px;
      right:50px;
      background-color: chartreuse;
      position: absolute;
    }
  </style>

  <h1 class="page-header" id="firsth1">Title Page 1</h1>
  <h2 class="page-header" style="font-size: 30px ;color:brown;">Title Page 2</h2>
  <h3>Title Page 3</h3>
  <br>
  <p><a href="https://getbootstrap.com/" target="_blank">This Link Has Been Visited</a></p>
  <p><a href="https://google.com/">This Link Has Not Been Visited</a></p>
  <br>

  <div class="absolute-example"></div>

  <div class="container pt-3">
    <table class="table table-dark table-striped table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">First</th>
          <th scope="col">Last</th>
          <th scope="col">Handle</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td colspan="2">Larry the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>

    <button type="button" class="btn btn-sm btn-primary">Submit</button>
    <button type="button" class="btn btn-sm btn-danger">Cancel</button>
  </div>

<jsp:include page="include/footer.jsp" />
