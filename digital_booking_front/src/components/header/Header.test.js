import { render, fireEvent, act, getByText } from "@testing-library/react";
import '@testing-library/jest-dom'
import Header from "./Header";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';



describe("Header", () => {
    it("logo renders", () => {
        const { getByTestId } = render(<Router><Header /></Router>);

        const logo = getByTestId("logo-testid");

        expect(logo).toBeInTheDocument
    });

    it("login button is rendered", () => {
        const { getByTestId } = render(<Router><Header /></Router>);

        const loginButton = getByTestId("login-button");

        expect(loginButton).toBeInTheDocument
    });
    it("signup button is rendered", () => {
        const { getByTestId } = render(<Router><Header /></Router>);

        const signupButton = getByTestId("signup-button");

        expect(signupButton).toBeInTheDocument
    });
    it("signup button navigate to SignUp component", () => {
        const { getByTestId, history } = render(
          <Router>
            <Header />
            <Routes>
            <Route path="/signup" data-testid="signup-component" />
            </Routes>
          </Router>
        );
      
        const signupButton = getByTestId("signup-button");
        fireEvent.click(signupButton);
      
        expect(history.location.pathname).toBe("/signup");
      });

});
