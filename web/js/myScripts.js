/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function evtEnviaForm()
{
    event.preventDefault(); // evita refresh da tela
    let frm = $("#formulario");    
    jQuery.ajax(
    {
        type: "POST",
        url: "Consulta",
        data: frm.serialize(),
        success: function (data) 
        {
            //var result = data;
            $('#tabela').html(data);

        }
    });
}