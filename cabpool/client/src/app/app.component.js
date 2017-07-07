"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var AppComponent = (function () {
    function AppComponent(elRef) {
        this.elRef = elRef;
        this.todo = {
            //id:1,
            description: "",
            status: false,
            comment: ""
        };
        this.title = "Manage Work";
        this.isEditable = false;
        this.todoList = [];
        this.doneList = [];
    }
    AppComponent.prototype.addToDo = function (desc) {
        this.todoList.push(this.todo);
        this.todo = {
            description: "",
            status: false,
            comment: ""
        };
    };
    ;
    AppComponent.prototype.removeToDO = function (index) {
        this.todoList.splice(index, 1);
    };
    
    AppComponent.prototype.moveToDoneList = function (index) {
        var doneTodo = this.todoList[index];
        doneTodo.status = true;
        doneTodo.comment = "Done on time";
        this.doneList.push(doneTodo);
        this.todoList.splice(index, 1);
    };
    AppComponent.prototype.addBack = function (i) {
        var notDoneTodo = this.doneList[i];
        notDoneTodo.status = false;
        this.todoList.push(notDoneTodo);
        this.doneList.splice(i, 1);
    };
    AppComponent.prototype.displaySaveBtn = function (i) {
        //this.elRef.nativeElement.
        $("#edit" + i).css("display", "block");
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'hello-app',
        templateUrl: './partials/todo.html',
        styleUrls: ['styles.css']
    }),
    __metadata("design:paramtypes", [core_1.ElementRef])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map