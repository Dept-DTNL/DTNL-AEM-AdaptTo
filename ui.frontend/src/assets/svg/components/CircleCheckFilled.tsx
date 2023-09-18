import React, { forwardRef } from 'react'
const CircleCheckFilledIcon = forwardRef<SVGSVGElement>(({ ...props }, svgRef) => {
  return (
    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 18" ref={svgRef} {...props}>
      <circle cx={9} cy={9} r={9} fill="#00B3E3" />
      <path stroke="#fff" strokeWidth={2} d="M4 9.5L7.301 12 13 6" />
    </svg>
  )
})
export default CircleCheckFilledIcon
