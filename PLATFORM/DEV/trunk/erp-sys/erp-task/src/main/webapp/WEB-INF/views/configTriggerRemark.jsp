<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/common/taglibs.jsp"%>
<html>
  <head>
    <title>配置说明</title>
  </head>
  
  <body style="padding: 10px;">
  
 	<br>
	<h1>操作</h1>
	<span><a href="/jobClassList">返回</a></span>
	
	<div>
	<br />反斜线（/）字符表示增量值。例如，在秒字段中“5/15”代表从第 5 秒开始，每 15 秒一次。
	<br />问号（?）字符和字母 L 字符只有在月内日期和周内日期字段中可用。问号表示这个字段不包含具体值。所以，如果指定月内日期，可以在周内日期字段中插入“?”，表示周内日期值无关紧要。字母 L 字符是 last 的缩写。放在月内日期字段中，表示安排在当月最后一天执行。在周内日期字段中，如果“L”单独存在，就等于“7”，否则代表当月内周内日期的最后一个实例。所以“0L”表示安排在当月的最后一个星期日执行。
	<br />在月内日期字段中的字母（W）字符把执行安排在最靠近指定值的工作日。把“1W”放在月内日期字段中，表示把执行安排在当月的第一个工作日内。
	<br />井号（#）字符为给定月份指定具体的工作日实例。把“MON#2”放在周内日期字段中，表示把任务安排在当月的第二个星期一。
	<br />星号（*）字符是通配字符，表示该字段可以接受任何可能的值。
	<br />
	<br />0 0 12 * * ? 		..................... 在每天中午12：00触发
	<br />0 15 10 ? * * 		..................... 每天上午10:15 触发
	<br />0 15 10 * * ? 		..................... 每天上午10:15 触发
	<br />0 15 10 * * ? * 	..................... 每天上午10:15 触发
	<br />0 15 10 * * ? 2005 	..................... 在2005年中的每天上午10:15 触发
	<br />0 * 14 * * ? 		..................... 每天在下午2：00至2：59之间每分钟触发一次
	<br />0 0/5 14 * * ? 		..................... 每天在下午2：00至2：59之间每5分钟触发一次
	<br />0 0/5 14,18 * * ? 	..................... 每天在下午2：00至2：59和6：00至6：59之间的每5分钟触发一次
	<br />0 0-5 14 * * ? 		..................... 每天在下午2：00至2：05之间每分钟触发一次
	<br />0 10,44 14 ? 3 WED 	..................... 每三月份的星期三在下午2：00和2：44时触发
	<br />0 15 10 ? * MON-FRI ..................... 从星期一至星期五的每天上午10：15触发
	<br />0 15 10 15 * ? 		..................... 在每个月的每15天的上午10：15触发
	<br />0 15 10 L * ? 		..................... 在每个月的最后一天的上午10：15触发
	<br />0 15 10 ? * 6L 		..................... 在每个月的最后一个星期五的上午10：15触发
	<br />0 15 10 ? * 6L 2002-2005 ................ 在2002, 2003, 2004 and 2005年的每个月的最后一个星期五的上午10：15触发
	<br />0 15 10 ? * 6#3 	..................... 在每个月的第三个星期五的上午10：15触发
	<br />0 0 12 1/5 * ? 		..................... 从每月的第一天起每过5天的中午12：00时触发
	<br />0 11 11 11 11 ? 	..................... 在每个11月11日的上午11：11时触发.­
	<br />
	<br />天天早上6点         0 6 * * *
	<br />每两个小时           0 */2 * * *
	<br />晚上11点到早上8点之间每两个小时，早上八点 0 23-7/2，8 * * *
	<br />每个月的4号和每个礼拜的礼拜一到礼拜三的早上11点 0 11 4 * 1-3
	<br />1月1日早上4点     0 4 1 1 *
	</div>
	
  </body>
</html>