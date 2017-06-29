<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    clickController('')
    function clickController(type) {
        $('.adminContent').load("AdminController", {controller: type});
    }
</script>
<div class="columns">
  <div class="content adminContent column is-10">

  </div>
</div>