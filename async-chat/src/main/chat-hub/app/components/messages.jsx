import React from 'react';
import { connect } from 'react-redux';
import HumanizedTime from './humanized_time';
import UserAvatar from './avatar';
import '../styles/messages.scss';

class Messages extends React.Component {
  renderMessages() {
    return this.props.messages.map(message => {
      return (
        <div key={message.id} className="list-group-item">
          <div className="media">
            <div className="media-left">
              <UserAvatar size="24" name={message.user.alias} />
            </div>
            <div className="media-body">
              <div className="row">
                <div className="col-md-2 text-left text-info">
                  &nbsp;&nbsp;{message.user.alias}
                </div>
                <div className="col-md-8 text-left">{message.message}</div>
                <div className="col-md-2 text-right text-info">
                  <small><HumanizedTime date={message.timestamp} /></small>
                </div>
              </div>
            </div>
          </div>
        </div>
      );
    });
  }
  render() {
    return (
      <div className="list-group chat-messages panel">
        {this.renderMessages()}
        <div ref={(div) => {
          if (div) div.scrollIntoView({ block: 'end', behavior: 'smooth' });
        }}></div>
      </div>
    );
  }

}

function mapStateToProps(state) {
  return { messages: state.messages };
}

export default connect(mapStateToProps)(Messages);
