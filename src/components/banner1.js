import React, { Fragment } from 'react'

import PropTypes from 'prop-types'

import './banner1.css'

const Banner1 = (props) => {
  return (
    <div
      className={`banner1-container1 thq-section-padding ${props.rootClassName} `}
    >
      <div className="banner1-max-width thq-section-max-width">
        <div className="banner1-container2">
          <h2>
            {props.heading1 ?? (
              <Fragment>
                <h2 className="banner1-text7 thq-heading-2">
                  Your trusty partner in medication safety
                </h2>
              </Fragment>
            )}
          </h2>
          <h3>
            {props.content1 ?? (
              <Fragment>
                <h3 className="banner1-text3 thq-heading-3">
                  Discover our exclusive collection
                </h3>
              </Fragment>
            )}
          </h3>
        </div>
        <button type="button" className="thq-button-filled">
          <span>
            {props.action1 ?? (
              <Fragment>
                <span className="banner1-text4">
                  <span>Enter Medication Information</span>
                  <br></br>
                </span>
              </Fragment>
            )}
          </span>
        </button>
      </div>
    </div>
  )
}

Banner1.defaultProps = {
  content1: undefined,
  action1: undefined,
  heading1: undefined,
  rootClassName: '',
}

Banner1.propTypes = {
  content1: PropTypes.element,
  action1: PropTypes.element,
  heading1: PropTypes.element,
  rootClassName: PropTypes.string,
}

export default Banner1
