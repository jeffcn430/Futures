INSERT into POSITION (variety_id,bbi,start_point,start_time,end_point,end_time,teacher_id,remarks,poundage,number,status,platform_id,loss)
SELECT variety_id,bbi,start_point,start_time,end_point,end_time,teacher_id,remarks,poundage,number,1,1,ROUND(loss,2)
from orders
order by start_time;



