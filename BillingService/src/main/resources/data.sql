insert into product(PRODUCTNAME,barcode,description,image,units,amount,barcodeImage)
values('AVOX Telephone','','AVOX Telephone','',200,250,'');

insert into invoice(client ,vatrate ,invoicedate,dueDate,dateSent,datePaid,tax ,totalBalanceDue,balanceDue,amountPaid ,productID)
values('Matimba Chauke' ,10 ,now(),now(),now(),null,25.00,275.00,275.00,0 ,1)