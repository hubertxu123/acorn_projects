function plugin0() {
    return document.getElementById('plugin0');
}

plugin = plugin0;

function addEvent(obj, name, func) {
    if (obj.attachEvent) {
        obj.attachEvent("on" + name, func);
    } else {
        obj.addEventListener(name, func, false);
    }
}

function pluginValid() {
    plugin().softPhone = "1";
    plugin().agentSvrIP = "139.196.230.47";
    plugin().agentSvrPort = "6868";
    plugin().fileLog = "1";
    plugin().fileLogLvl = "0";

    if (plugin().valid) {
        //签入、签出动作响应
        addAgentEvent();

        //进线时回调
        addCallEvent();

        //查询呼叫队列情况
        addQueueEvent();

        //CTI连接状态初始化
        addSessionStatusChanged();

        //定时查询软电话登录状态
        startQuerySoftPhoneTimer();

        plugin().start();
    }
    else {
        alert("lAgentBar is not working :(");
    }
}

//签入、签出动作响应
function addAgentEvent() {
    addEvent(plugin(), 'agentStateEvent', function (deviceID, agentID, agentState) {
        $("#lblDeviceID").html(deviceID);
        $("#lblAgentID").html(agentID);
        $("#lblAgentState").html(getAgentStateText(agentState));

        if (agentState == "LOGIN") {
            onReady();
            startQueryTimer();
        }

        if (agentState == "LOGOUT") {
            offline();
            stopQueryTimer();
        }
    });
}

function getAgentStateText(agentState) {
    var agentStateText = "签出";
    switch (agentState) {
        case "LOGIN":
            agentStateText = "签入";
            break;
        case "LOGOUT":
            agentStateText = "签出";
            break;
        case "PAUSE":
            agentStateText = "暂停";
            break;
        case "WORK":
            agentStateText = "工作";
            break;
        case "DEAL":
            agentStateText = "处理";
            break;
        default:
    }

    return agentStateText;
}

function startQueryTimer() {
    $('body').everyTime('3s', 'tmrQuery', doQueryTimer);
}

function doQueryTimer() {
    plugin().queryQueueInfo();
}

function stopQueryTimer() {
    $('body').stopTime('tmrQuery');
}

//进线时回调
function addCallEvent() {
    addEvent(plugin(), 'callStateEvent', function (deviceID, callID, callState, ani, dnis, uui) {
        var callCount = plugin().getCallCount();

        if (callState != "CS_NONE")
            $("#lblCallState").html(getCallStateText(callState));
        else if (callState == "CS_NONE" && callCount == 0) {
            $("#lblCallState").html(getCallStateText("CS_NONE"));
            onReady();
        }

        if (callState == "CS_INCOMING") {
            $("#callID").val(callID);
            $("#phoneInput").val(callID);
            $("#remoteID").val(ani);
            onRinging();
        }
        else if (callState == "CS_ORGINATED" && callCount == 1) {
            $("#callID").val(callID);
        }

        if (callState == "CS_CONNECT" && callCount == 1 && iAnswerTimer == 0) {
            startAnswerTimer();
            onTalking();
        }


        if (callState == "CS_NONE" && callCount == 0) {
            $("#callID").val("");
            stopAnswerTimer();
        }

        if (callState == "CS_ALERTING") {
            onDialing();
        }
    });
}

var iAnswerTimer = 0;
function startAnswerTimer() {
    iAnswerTimer = 0;
    $('body').everyTime('1s', 'tmrAnswer', doAnswerTimer);
}

function doAnswerTimer() {
    iAnswerTimer++;

    var fmtTime = formatSeconds(iAnswerTimer);
    $("#lblAnswerTimer").html("通话计时：" + fmtTime);
}

function stopAnswerTimer() {
    iAnswerTimer = 0;

    $('body').stopTime('tmrAnswer');
    $("#lblAnswerTimer").html("通话计时：00:00:00");
}

function getCallStateText(callState) {
    var callStateText = "空闲";
    switch (callState) {
        case "CS_INITIATE":
            callStateText = "接机";
            break;
        case "CS_ORGINATED":
            callStateText = "拨号";
            break;
        case "CS_INCOMING":
            callStateText = "振铃";
            break;
        case "CS_ALERTING":
            callStateText = "振铃";
            break;
        case "CS_CONNECT":
            callStateText = "接通";
            break;
        case "CS_HOLD":
            callStateText = "保持";
            break;
        case "CS_NONE":
            callStateText = "空闲";
            break;
        default:
    }

    return callStateText;
}

function addQueueEvent() {
    addEvent(plugin(), 'queueStateEvent', function (total, queue, answer) {

        $("#lblTotalCall").html(total);
        $("#lblQueueCall").html(queue);
    });
}


function addSessionStatusChanged() {
    addEvent(plugin(), 'sessionStatusChanged', function (isConnected) {
        if (isConnected) {
            $("#softPhoneLoginBtn").show();
        }
    });
}

function startQuerySoftPhoneTimer() {
    $('body').everyTime('3s', 'tmrQuerySoftPhone', doQuerySoftPhoneTimer);
}

var preSoftPhoneState = "0";
function doQuerySoftPhoneTimer() {
    var softPhoneState = plugin().querySoftPhone();

    if (preSoftPhoneState == softPhoneState)
        return;
    preSoftPhoneState = softPhoneState;
    if (softPhoneState == "1")
        imgStatus2.src = "libs/images/conn.png";
    if (softPhoneState == "0")
        imgStatus2.src = "libs/images/disconn.png";
}

function agentLogin() {
    var deviceID = $("#cti-agentNo").val(),
        agentID = $("#cti-username").val(),
        password = $("#cti-password").val();

    var result = plugin().agentLogin(deviceID, agentID, password);
    if (result != 1)
        alert(result);
}

function outPhone() {
    var phone = $("#phoneInput").val();
    var calledUUI = "gw1";

    plugin().makeCall(phone, calledUUI);
}

function shutdownPhone() {
    var callID = getCallID();
    if (callID != "")
        plugin().hangupCall(callID);
}

function getCallID() {
    return $("#callID").val();
}

function agentBarLogout() {
    var result = plugin().agentLogout();

    if (result == 1) {
    } else alert(result);
}

function pickupPhone() {
    var callID = getCallID();
    if (callID != "")
        plugin().answerCall(callID);
}