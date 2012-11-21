<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Manager - Struts2 Hibernate Example</title></head>
<body>
<h1>Contact Manager</h1>
<s:actionerror/>
<s:form action="add" namespace="/contactManager" method="post">
    <s:textfield name="contact.firstName" label="Firstname"/>
    <s:textfield name="contact.lastName" label="Lastname"/>
    <s:textfield name="contact.emailId" label="Email"/>
    <s:textfield name="contact.cellNo" label="Cell No."/>
    <s:textfield name="contact.website" label="Homepage"/>
    <s:textfield name="contact.birthDate" label="Birthdate"/>
    <s:submit value="Add Contact" align="center"/>
</s:form>
 
 
<h2>Contacts</h2>
<table>
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Cell No.</th>
    <th>Birthdate</th>
    <th>Homepage</th>
    <th>Delete</th>
</tr>
<s:iterator value="contactList" var="contact">
    <tr>
        <td><s:property value="lastName"/>, <s:property value="firstName"/> </td>
        <td><s:property value="emailId"/></td>
        <td><s:property value="cellNo"/></td>
        <td><s:property value="birthDate"/></td>
        <td><a href="<s:property value="website"/>">link</a></td>
        <td>
        	<s:url id="deleteURL" namespace="/contactManager" action="delete">
        		<s:param name="id" value="%{id}"></s:param>
        	</s:url>
        	<s:a href="%{deleteURL}">delete</s:a>
        </td>
    </tr> 
</s:iterator>
</table>
</body>
</html>