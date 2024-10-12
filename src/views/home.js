import React, { Fragment } from 'react'

import { Helmet } from 'react-helmet'

import Banner1 from '../components/banner1'
import './home.css'

const Home = (props) => {
  return (
    <div className="home-container">
      <Helmet>
        <title>Rectangular Dizzy Porcupine</title>
        <meta property="og:title" content="Rectangular Dizzy Porcupine" />
      </Helmet>
      <h1 className="home-text1">PillPal</h1>
      <Banner1
        content1={
          <Fragment>
            <span className="home-text2 thq-heading-3">
              Find out if how your medications interact with one another
            </span>
          </Fragment>
        }
        action1={
          <Fragment>
            <span className="home-text3">Enter Medication Information</span>
          </Fragment>
        }
        heading1={
          <Fragment>
            <span className="home-text4 thq-heading-2">
              Your trusty partner in medication safety
            </span>
          </Fragment>
        }
        rootClassName="banner1root-class-name"
      ></Banner1>
    </div>
  )
}

export default Home
