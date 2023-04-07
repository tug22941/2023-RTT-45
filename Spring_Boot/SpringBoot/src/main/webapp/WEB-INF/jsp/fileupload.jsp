<jsp:include page="include/header.jsp" />

<section class="pt-5 pb-5 bg-purple">
    <div class="container text-center">
        <h1>File Upload</h1>
    </div>
</section>

<section>
    <div class="container py-5 bg-light-purple">
        <div class="row justify-content-center">
            <div class="col-10">
                <form action="/fileupload" method="post" enctype="multipart/form-data">
                    <div class="mb-3 text-center">
                        <label for="fileupload" class="form-label">File Upload</label>
                        <input type="file" class="form-control" id="fileupload" name="fileupload" aria-describedby="fileuploadHelp">
                        <button class="btn btn-primary" onclick="toDetails()">Submit</button>
                    </div>
                    <div class="text-center">
                        <img class="w-100" src="${fileUrl}"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp" />
