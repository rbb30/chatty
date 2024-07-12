import React, { useState, useEffect } from 'react';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';

const Chat = () => {
  const [stompClient, setStompClient] = useState(null);
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    const socket = new SockJS('http://localhost:8080/ws');
    const client = Stomp.over(socket);

    client.connect({}, frame => {
      console.log('Connected: ' + frame);
      setStompClient(client);

      client.subscribe('/topic/messages', message => {
        console.log('Received message:', message);
        try {            
            var body = JSON.parse(message.body)
            body.timestamp = Date.now()
            setMessages(prevMessages => [...prevMessages, body]);
        }
        catch{
            console.log('error parsing message');
        }

      });
    });

    return () => {
      if (stompClient) {
        stompClient.disconnect();
      }
    };
  }, []);

  const sendMessage = (message) => {
    stompClient.send('/app/sendMessage', {}, JSON.stringify({ content: message }));
  };

  return (
    <div>
      <h1>Chat Application</h1>
      <div className="chat-window">
        {messages.map((message, index) => (
          <div key={index} className="chat-message">
            <span>{message.timestamp}</span>: <span>{message.content}</span>
          </div>
        ))}
      </div>
      <input type="text" placeholder="Type your message..." onKeyPress={(event) => {
        if (event.key === 'Enter') {
          sendMessage(event.target.value);
          event.target.value = '';
        }
      }} />
    </div>
  );
};

export default Chat;
