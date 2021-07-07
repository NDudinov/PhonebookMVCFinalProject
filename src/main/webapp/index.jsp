<html>
<body>
<h2>GridU Spring for automation engineer course capstone project</h2>
<p>
    You have several endpoints for HTTP requests
</p>
<div> GET - receive all phoneBook records: api/v1//contacts/</div>

<div> GET/{name} - all phones for the given name: api/v1//contacts/{name}</div>

<div> PUT/{name}; phoneNumber - add phone to existing name : api/v1//contacts/{contactName} RequestParam(name = "newPhone")
</div>
<div> POST/; {"name"”":"YourName, "phoneNumber": "+79998887711"} - create a new record in the phoneBook: api/v1//contacts/add
</div>
<div> Request body:
    <p> { </p>
    <p> "contactName": "Joe",</p>
    <p> "phone": "+99999999999"</p>
    <p> }</p>
</div>
<div> DELETE/{name} - removes record by name completely (including associated phone numbers) : /contacts/{name}
</div>
</body>
</html>
