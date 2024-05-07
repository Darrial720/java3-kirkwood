<%@include file="/WEB-INF/personal_project/top.jsp"%>
<main class="container">
  <section class="p-0 d-flex align-items-center position-relative overflow-hidden">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12 col-lg-8 m-auto">
          <div class="row my-5">
            <div class="col-sm-10 col-xl-8 m-auto">
              <c:choose>
                <c:when test="${not empty results.Success}">
                  <p class="alert alert-success">
                      ${results.Success}
                  </p>
                </c:when>
                <c:when test="${not empty results.creationError}">
                  <p class="alert alert-danger">
                      ${results.creationError}
                  </p>
                </c:when>
                <c:otherwise>
                </c:otherwise>
              </c:choose>
              <h2>Create Character Below</h2>
              <form action="${appURL}/create-character" method="post">
                <div class="mb-4">
                  <label for="inputCharacterName" class="form-label">Character Name *</label>
                  <div class="input-group input-group-lg">
                    <span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="Character Name" id="inputCharacterName" name="inputCharacterName"  value="${results.CharacterName}">
                  </div>
                </div>
                <div class="mb-4">
                  <label for="inputCharacterStatus" class="form-label">Character Status *</label>
                  <div class="input-group input-group-lg">
                    <span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="fa fa-star"></i></span>
                    <input type="text" class="form-control border-0 bg-light rounded-end ps-1 " placeholder="playable" id="inputCharacterStatus" name="inputCharacterStatus"  value="${results.CharacterStatus}">
                  </div>
                </div>
                <div class="mb-4">
                  <label for="inputCharacterUnlockLevel" class="form-label">Character Unlock Level *</label>
                  <div class="input-group input-group-lg">
                    <span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="fas fa-lock"></i></span>
                    <input type="text" class="form-control border-0 bg-light rounded-end ps-1 " placeholder="1" id="inputCharacterUnlockLevel" name="inputCharacterUnlockLevel"  value="${results.CharacterUnlockLevel}">
                  </div>
                </div>
                <!-- Button -->
                <div class="align-items-center mt-0">
                  <div class="d-grid">
                    <button class="btn btn-orange mb-0" type="submit">Submit</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>
<%@include file="/WEB-INF/personal_project/bottom.jsp"%>
