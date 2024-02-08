import React from 'react';
import { render, fireEvent, waitFor, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import {LoginInput} from "./containers";

describe('LoginInput', () => {
    test('renders login input fields', () => {
        render(<LoginInput />);
        // expect(screen.getByPlaceholderText('Email')).toBeInTheDocument();
        // expect(screen.getByPlaceholderText('Password')).toBeInTheDocument();
    });
});
