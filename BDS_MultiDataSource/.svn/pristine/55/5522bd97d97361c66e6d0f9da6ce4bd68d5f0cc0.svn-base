importScripts('firebase-app.js');
importScripts('firebase-messaging.js');
importScripts('firebase-init.js');
/*
    payload에 notification 속성이 존재하면 아래 코드는 실행되지 않고
    payload에 명시된 notification 대로 처리됨.
*/
firebase.messaging().setBackgroundMessageHandler(function(payload) {
    return self.registration.showNotification("title", {
        body: 'body',
        icon: 'https://image.flaticon.com/icons/png/512/134/134937.png',
        click_action: 'http://www.naver.com'
    });
});