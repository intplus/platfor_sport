function Add(id){

	var name= prompt("write tittle of group" ,"write here");
	//alert("you name "+ name);
	var newGroup = document.getElementsByTagName("ul")[1]
	// var newUl = document.createElement("ui");
	var newLi = document.createElement("li");
	var a = document.createElement("a");
	a.setAttribute('href', "http://facebook.com");
	a.setAttribute('id', name);
//	a.appendChild(document.setProperty("in",name)).href="http://localhost:8080/registerPerson//showFormForAdd";
	a.appendChild(document.createTextNode(name));
	newLi.appendChild(a);
	newGroup.appendChild(newLi)


}


function save() {




}