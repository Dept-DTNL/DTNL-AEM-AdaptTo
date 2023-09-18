import React, { forwardRef } from 'react'
const ChevronLeftIcon = forwardRef<SVGSVGElement>(({ ...props }, svgRef) => {
  return (
    <svg fill="none" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 13 20" ref={svgRef} {...props}>
      <path d="M11.49 1L2 10.192l9.49 9.193" stroke="currentColor" strokeWidth={1.5} />
    </svg>
  )
})
export default ChevronLeftIcon
