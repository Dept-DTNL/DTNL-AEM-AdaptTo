import React from 'react'

export type DebugBarProps = {
  title: string;
  description?: string
  runMode?: string}

class DebugBar extends React.Component<DebugBarProps, any> {
  render() {
    const authorMode = this.props?.runMode === "AUTHOR";
      return (
        <>
        { authorMode &&
          (<div className="debug " >
          <span>
            <h6>{this.props.title}</h6>
            <p>{this.props.description || 'Component not properly configured in AEM'}</p>
          </span>
          </div>)
        }
        </>
      )
  }
}

export default DebugBar
