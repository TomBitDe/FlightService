update app.FLGTSGMT set app.FLGTSGMT.PAXEXIT = 'T3' where app.FLGTSGMT.FLGTNO = 'EK 98' and app.FLGTSGMT.SCHEDFLGTDT = '20190109' and app.FLGTSGMT.ARPO = 'DXB';

update app.FLGTSGMT set app.FLGTSGMT.FLGTSTATUS = 0 where app.FLGTSGMT.FLGTNO = 'EK 98' and app.FLGTSGMT.SCHEDFLGTDT = '20190109' and app.FLGTSGMT.ARPO = 'DXB';

update app.FLGTSGMTSCHEDULE set app.FLGTSGMTSCHEDULE.EAT = CURRENT_TIMESTAMP where app.FLGTSGMTSCHEDULE.FLGTNO = 'EK 98' and app.FLGTSGMTSCHEDULE.SCHEDFLGTDT = '20190109' and app.FLGTSGMTSCHEDULE.ARPO = 'DXB';