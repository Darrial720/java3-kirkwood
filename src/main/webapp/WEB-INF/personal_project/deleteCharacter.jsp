<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main class="container">
  <section class="pt-0">
    <div class="container">
      <div class="row">
        <c:choose>
          <c:when test="${not empty results.Success}">
            <p class="alert alert-success">
                ${results.Success}
            </p>
          </c:when>
          <c:when test="${not empty results.deletionError}">
            <p class="alert alert-danger">
                ${results.deletionError}
            </p>
          </c:when>
          <c:otherwise>
          </c:otherwise>
        </c:choose>
        <div class="col-xl-9">
          <div class="card border bg-transparent rounded-3 mb-0">
            <div class="card-header bg-transparent border-bottom">
              <h3 class="card-header-title mb-0">${pageTitle}</h3>
            </div>
            <!-- Card body -->
            <div class="card-body">
              <form method="POST" action="${appURL}/delete-character?id=${character.character_id}">
                <button type="submit" class="btn btn-danger mb-0">Delete character</button>
              </form>
            </div>
          </div>
          <!-- Title and select END -->
        </div>
        <!-- Main content END -->
      </div><!-- Row END -->
    </div>
  </section>
</main>
<%@include file="/WEB-INF/personal_project/bottom.jsp"%>

