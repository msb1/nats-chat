import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

export default function(ComposedComponent) {
  class RequireUser extends React.Component {

    static contextTypes = {
      router: PropTypes.object.isRequired
    }

    componentWillMount(){
      if(!this.props.user.alias){
        this.context.router.history.push('/');
      }
    }

    componentWillUpdate(nextProps){
      if(!nextProps.user.alias){
        this.context.router.history.push('/');
      }
    }

    render(){
      return <ComposedComponent {...this.props}/>
    }
  }

  function mapStateToProps({user}) {
    return {user};
  }

  return connect(mapStateToProps)(RequireUser);
}
