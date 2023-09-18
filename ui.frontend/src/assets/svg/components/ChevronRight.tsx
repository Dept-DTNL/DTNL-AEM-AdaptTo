import React, { forwardRef } from 'react'
const ChevronRightIcon = forwardRef<SVGSVGElement>(({ ...props }, svgRef) => {
  return (
    <svg viewBox="0 0 7 11" fill="none" xmlns="http://www.w3.org/2000/svg" ref={svgRef} {...props}>
      <path d="M.95 10.45L5.9 5.5.95.55" stroke="currentColor" />
    </svg>
  )
})
export default ChevronRightIcon
