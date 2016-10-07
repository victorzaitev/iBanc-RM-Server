/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Mai 30, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('orderNotesModalController', ['$scope', '$uibModalInstance', 'orderId', 'userStatus', 'orderNotesService', 'noteGroupsService', function ($scope, $uibModalInstance, orderId, userStatus, orderNotesService, noteGroupsService) {

        var self = this;
        self.orderId = orderId;
        self.userStatus = userStatus;

        $scope.gridOrderNotes = {};
        $scope.addNoteButtonFlag = true;
        $scope.addNoteFormFlag = false;
        $scope.deleteNoteFlag = false;
        $scope.editNoteFlag = false;
        $scope.newNote = {};
        $scope.noteGroups = {};

        switch (self.userStatus) {
            case "full":
                $scope.addNoteButtonFlag = true;
                $scope.deleteNoteFlag = true;
                break;
            case "insert":
                $scope.addNoteButtonFlag = true;
                $scope.deleteNoteFlag = false;
                break;
            default:
                $scope.addNoteButtonFlag = false;
                $scope.deleteNoteFlag = false;
                break;
        };

        self.fetchAllNoteGroupsService = function () {
            $scope.noteGroups = noteGroupsService.NoteGroups().query();
        };

        self.fetchAllOrderNotesService = function () {

            $scope.gridOrderNotes = orderNotesService.OrderNotes().query({idCod: self.orderId});
            self.fetchAllNoteGroupsService();
            
        };

        self.fetchAllOrderNotesService();

        $scope.deleteNote = function (row) {
            orderNotesService.OrderNotes().remove({note: row.id}).$promise.then(function () {
                console.info("Note with id = " + row.id + " was deleted");
            });

        };

        $scope.updateNote = function (row) {
            orderNotesService.noteUpdate(self.buildNoteDataToUpdate(row)).then(function (results) {
                console.info("Note => " + row + " was update "+results);
            });

//            orderNotesService.OrderNotes().update(self.buildNoteDataToUpdate(row)).$promise.then(function () {
//                console.info("Note => " + row + " was update");
//            });
        };

        $scope.showNoteFrom = function () {
            $scope.addNoteButtonFlag = false;
            $scope.editNoteFlag = true;
            $scope.addNoteFormFlag = true;
            console.info("showNoteFrom");
        };

        $scope.addNewNote = function () {
            $scope.addNoteButtonFlag = true;
            $scope.addNoteFormFlag = false;
            $scope.editNoteFlag = false;
            
            var note = {};
            note.orderId = self.orderId;
            note.noteGroupId = $scope.newNote.parameter.value;
            note.noteConntent = $scope.newNote.noteConntent;
            
            console.info("------- was added newNote ------------");
            console.info(note);
            
            orderNotesService.OrderNotes().create(note);
            
        };

        $scope.closeModal = function () {
            $uibModalInstance.close('close');
        };

        self.buildNoteDataToUpdate = function (note) {

            var noteToUpdate = {};

            console.info(note);

            noteToUpdate.noteId = note.id;
            noteToUpdate.noteConntent = note.note;

            console.info(noteToUpdate);
            return noteToUpdate;
        };

        self.removeItem = function (index, row) {

            delete row[index];

            console.info(row);

            return row;

        };

    }]);