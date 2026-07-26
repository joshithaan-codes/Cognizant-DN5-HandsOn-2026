import React from 'react';
import { shallow } from 'enzyme';
import CohortDetails from './CohortDetails';

describe('CohortDetails Component', () => {

  const props = {
    cohortCode: 'INTADMDF10'
  };

  it('should render CohortDetails component', () => {
    const wrapper = shallow(<CohortDetails {...props} />);
    expect(wrapper.exists()).toBe(true);
  });

  it('should receive cohortCode as a prop', () => {
    const component = <CohortDetails {...props} />;
    expect(component.props.cohortCode).toBe('INTADMDF10');
  });

  it('should contain an h3 tag', () => {
    const wrapper = shallow(<CohortDetails {...props} />);
    expect(wrapper.find('h3')).toHaveLength(1);
  });

  it('should display cohortCode inside h3', () => {
    const wrapper = shallow(<CohortDetails {...props} />);
    expect(wrapper.find('h3').text()).toBe('INTADMDF10');
  });

  it('should match the snapshot', () => {
    const wrapper = shallow(<CohortDetails {...props} />);
    expect(wrapper).toMatchSnapshot();
  });

});