import React from 'react'

class Home extends React.Component{

    render(){
        return(
            <div className="jumbotron">
                <p>
                    <a className="btn btn-primary btn-lg"
                       href="#/cadastro-usuario" role="button">
                           <i className="fa fa-users"></i>
                    </a>
                    <a className="btn btn-danger btn-lg"
                       href="#/login" role="button">
                           <i className="fa fa-users"></i>
                    </a>
                </p>
            </div>
        )
    }

}