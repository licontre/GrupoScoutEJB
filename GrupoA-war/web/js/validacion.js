/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    
    $.validator.setDefaults({
        highlight: function(element){
            $(element)
                .closest('.form-control')
                .addClass('con-error');
        },
        unhighlight: function(element){
            $(element)
                    .closest('.form-control')
                    .removeClass('con-error');
        }
    }); 
    
    $("#registro").validate({

        rules: {
            nombre: {
                required: true,
                nowhitespace: true,
                lettersonly: true
            },
            apellido1: {
                required: true,
                nowhitespace: true,
                lettersonly: true
            },
            apellido2: {
                required: true,
                nowhitespace: true,
                lettersonly: true
            }, dni: {
                required: true
            }, provincia: {
                required: true,
                nowhitespace: true,
                lettersonly: true
            }, localidad: {
                required: true,
                nowhitespace: true,
                lettersonly: true
            }, fecha: {
                required: true
            }, direccion: {
                required: true
            }, codpostal: {
                required: true
            }, alias: {
                required: true
            }, email: {
                required: true,
                email: true
            }, pass: {
                required: true
            }, pass2: {
                required: true,
                equalTo: '#pass'
            }
        },
        messages: {
            nombre: {
                required: 'Campo obligatorio',
                nowhitespace: 'Nombre no valido',
                lettersonly: 'Nombre no valido'
            }, apellido1: {
                required: 'Campo obligatorio',
                nowhitespace: 'Apellido no valido',
                lettersonly: 'Apllido no valido'
            }, apellido2: {
                required: 'Campo obligatorio',
                nowhitespace: 'Apellido no valido',
                lettersonly: 'Apllido no valido'
            }, dni:{
                required: 'Campo obligatorio'
            }, provincia:{
                required: 'Campo obligatorio',
                nowhitespace: 'Provincia no valida',
                lettersonly: 'Provincia no valida'
            }, localidad:{
                required: 'Campo obligatorio',
                nowhitespace: 'localidad no valida',
                lettersonly: 'localidad no valida'
            }, fecha:{
                required: 'Campo obligatorio'
            }, direccion:{
                required: 'Campo obligatorio'
            }, codpostal:{
                required: 'Campo obligatorio'
            }, alias:{
                required: 'Campo obligatorio'
            }, email:{
                required: 'Campo obligatorio',
                email: 'Introduce un email valido'
            }, pass:{
                required: 'Campo obligatorio'
            }, pass2:{
                required: 'Campo obligatorio',
                equalTo: 'Las contraseñas deben ser iguales'
            }
        }
    });

});


function getNombreVista(){
    var path = window.location.pathname;
    var output = path.split("/");
    var bool=false;
    if(output[3]==='registro.xhtml'){
        bool=true;
    }
    if( output[3]==='login.xhtml'){
        bool=true;
    }
    return bool;
}

