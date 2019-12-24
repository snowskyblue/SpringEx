<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<select name="select_projects" id="select_projects">
        <option value="">project.xml</option>
        <optgroup label="client1">
            <option value="">project2.xml</option>
        </optgroup>
        <optgroup label="client2">
            <option value="">project5.xml</option>
            <option value="">project6.xml</option>
            <optgroup label="client2_a">
                <option value="" style="margin-left:23px;">project7.xml</option>
                <option value="" style="margin-left:23px;">project8.xml</option>
            </optgroup>
            <option value="">project3.xml</option>
            <option value="">project4.xml</option>
       </optgroup>
       <option value="">project0.xml</option>
       <option value="">project1.xml</option>
    </select>
</body>
</html>
