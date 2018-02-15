<%@include file="../shared/header.jsp" %>
<h1>Enroll Now</h1>
<form id="enquiry" method="post" action="">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control" required="required"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required="required"/>
            </div>
            <div class="form-group">
                <label>Interested Course</label>
                <select name="course.id" class="form-control" required="required">
                    <option value="">Select Course</option>
                    <c:forEach var="course" items="${courses}">
                        <option value="${course.id}">
                            ${course.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control" required="required"/>
            </div
            <div class="form-group">
                <label>Contact</label>
                <input type="text" name="contactNo" class="form-control" required="required"/>
            </div>
        </div>
        <div class="form-group">
            <label>Message</label>
            <textarea name="message" class="form-control" required="required" style="height:100px"></textarea>
        </div>
        <input type="hidden" name="status.id" value="16"/>
    <button type="submit" class="btn btn-success">
        Enroll
    </button>
    </div>
    
</form>
<%@include file="../shared/footer.jsp" %>