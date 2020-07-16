import React, { Component }  from 'react';
import { connect } from 'react-redux';
import '../styles/profile.scss';
import UserAvatar from './avatar';

class UserProfile extends React.Component {
  render() {
    return (
      <div className="list-group user-profile">
        <div className="list-group-item">
          <UserAvatar size="48" name={this.props.user.alias} />
        </div>
        <div className="list-group-item">
          <p className="text-center">{this.props.user.alias}</p>
        </div>
      </div>
    );
  }
}

export default connect(({ user }) => ({ user }))(UserProfile);
